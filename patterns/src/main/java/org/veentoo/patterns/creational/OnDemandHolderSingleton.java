package org.veentoo.patterns.creational;

public class OnDemandHolderSingleton {

    public static class InstanceHolder {
        public static final OnDemandHolderSingleton instance = new OnDemandHolderSingleton();
    }

    public static OnDemandHolderSingleton getInstance() {
        return InstanceHolder.instance;
    }

    public static void main(String[] args) {
        OnDemandHolderSingleton instance = OnDemandHolderSingleton.getInstance();
    }
    
}
