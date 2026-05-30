package com.satyam.app.learning.functional.dispatchTable;

/**
 * Output:
 * recharge selected
 * */

import java.util.Map;

enum MenuOption {
    BALANCE,
    RECHARGE,
    HELP
}

public class DispatchTableDemo {
    private final Map<MenuOption,Runnable> menu;

    public DispatchTableDemo() {
        menu = Map.of(
                MenuOption.BALANCE,this::balance,
                MenuOption.RECHARGE,this::recharge,
                MenuOption.HELP,this::help
        );
    }

    public static void main(String[] args) {
        DispatchTableDemo app =
                new DispatchTableDemo();
        app.start();
    }

    private void start(){
        MenuOption option = MenuOption.RECHARGE;
        menu.getOrDefault(option,this::invalidOption)
                .run();
    }

    private void help() {
        System.out.println("help selected");
    }

    private void recharge() {
        System.out.println("recharge selected");
    }

    private void balance() {
        System.out.println("balance selected");
    }

    private void invalidOption(){
        System.out.println("invalid option");

    }
}
