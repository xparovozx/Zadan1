/**
 * Created by Vlad on 14.10.2016.
 */
package com.xparovozx.Zadan1;

public class Vershina<T> {
        private int id;
        private T data;

        public Vershina(int id, T data) {
            this.id = id;
            this.data = data;
        }

        public int getId() { return id; }

        public T getData() { return data; }
        public void setData(T data) { this.data = data; }

        @Override
        public String toString() {
            return "id = " + id;
        }
    }