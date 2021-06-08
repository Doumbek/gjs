package structural.bridge;

public class Example {

    public static void main(String[] args) {

        final RemoteControl tvRemoteControl = new CommonRemoteControl(new TV());
        final AdvancedRemoteControl radioRemoteControl = new AdvancedRemoteControl(new Radio());

        System.out.println(tvRemoteControl.getState());
        tvRemoteControl.volumeUp();
        tvRemoteControl.volumeUp();
        tvRemoteControl.volumeUp();
        tvRemoteControl.volumeDown();
        System.out.println(tvRemoteControl.getState());

        System.out.println("===============================");

        System.out.println(radioRemoteControl.getState());
        radioRemoteControl.volumeUp();
        radioRemoteControl.volumeUp();
        radioRemoteControl.volumeUp();
        radioRemoteControl.volumeUp();
        radioRemoteControl.volumeDown();
        radioRemoteControl.mute();
        System.out.println(radioRemoteControl.getState());

    }

}
