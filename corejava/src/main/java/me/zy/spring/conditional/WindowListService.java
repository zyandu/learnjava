package me.zy.spring.conditional;

public class WindowListService implements ListService {
    @Override
    public String showListCmd() {
        return "dir";
    }
}
