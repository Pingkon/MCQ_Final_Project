package com.iub.mcq_final_project;

public class Category {

    public void setName(String name)
    {
        this.name=name
    }

    @Override
    public String toString()
    {
        return getName();
    }
}
