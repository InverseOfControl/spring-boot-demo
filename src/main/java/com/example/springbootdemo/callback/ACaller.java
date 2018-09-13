package com.example.springbootdemo.callback;

public class ACaller {

    public void call(ICallBack callBack){
        callBack.call();
    }

    public static void main(String[] args) {
        new ACaller().call(new ICallBack(){
            @Override
            public void call() {
                System.out.println("ACaller.call");
            }
        });
    }
}
