package com.javarush.task.task29.task2909.human;

/**
 * Created by Юлиана on 02.10.2017.
 */
public class BloodGroup {
    private final int code;

    private BloodGroup (int code){        this.code = code;    }

    public int getCode() {        return code;    }

    static BloodGroup first(){        return new BloodGroup(1);    }

    static BloodGroup second(){        return new BloodGroup(2);    }

    static BloodGroup third(){        return new BloodGroup(3);    }

    static BloodGroup fourth(){        return new BloodGroup(4);    }
}
