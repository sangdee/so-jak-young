package com.cbnu.sjy_.util;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author : Sangji Lee
 * @when : 2019-11-17 오후 7:16
 * @homepage : https://github.com/sangji11
 */
@SuppressWarnings("unchecked")
public final class Firebase {

    public static FirebaseAuth auth() {
        return FirebaseAuth.getInstance();
    }

    public static String uid() {
        return auth().getUid();
    }

    public static FirebaseAccessor reference() {
        return LazyHolder.instance.reference();
    }

    public static FirebaseAccessor reference(String root) {
        return LazyHolder.instance.reference(root);
    }

    static final class LazyHolder {
        static FirebaseAccessor instance = new FirebaseAccessor();
    }

    public final static class FirebaseAccessor {
        private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        private FirebaseAccessor() {

        }

        private FirebaseAccessor reference() {
            reference = FirebaseDatabase.getInstance().getReference();
            return this;
        }

        private FirebaseAccessor reference(String root) {
            reference = FirebaseDatabase.getInstance().getReference(root);
            return this;
        }

        public FirebaseAccessor child(String path) {
            reference = reference.child(path);
            return this;
        }

        public <T> FirebaseProcessor<T> access(Class<T> clazz) {
            //RxJava Style
            return new FirebaseProcessor<>(reference, clazz);
        }
    }

    public final static class FirebaseProcessor<T> {
        private DatabaseReference reference;
        private Class<T> clazz;

        private FirebaseProcessor(DatabaseReference reference, Class<T> clazz) {
            this.reference = reference;
            this.clazz = clazz;
        }

        public void insert(T val) {
            // insert and update are same
            reference.setValue(val);
        }

        public void delete() {
            reference.setValue(null);
        }

        public void selectList(Consumer<List<T>> after) {
            reference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    List<T> list = new ArrayList<>();
                    for (DataSnapshot o : dataSnapshot.getChildren()) {
                        list.add(o.getValue(clazz));
                    }
                    after.accept(list);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        public void select(Consumer<T> after) {
            reference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    T t = dataSnapshot.getValue(clazz);
                    after.accept(t);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }
}
