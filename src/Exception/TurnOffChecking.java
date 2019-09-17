package Exception;

import java.io.*;

class WrapCheckedException{
    void throwRuntimeException(int type){
        try{
            switch (type){
                case 0: throw new FileNotFoundException();
                case 1: throw new IOException();
                case 2: throw new RuntimeException();
                default: return;
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
public class TurnOffChecking {
}
