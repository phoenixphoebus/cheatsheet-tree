package com.aditya.java.tree.pojo;

import java.util.Objects;

public class Node<T> {
    public T data;
    public Node<T> left;
    public Node<T> right;

    public Node(T data) {
        super();
        this.data = data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, left, right);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node<?> other = (Node<?>) obj;
        return Objects.equals(data, other.data) && Objects.equals(left, other.left)
                && Objects.equals(right, other.right);
    }

}
