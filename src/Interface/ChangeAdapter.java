package Interface;

public class ChangeAdapter implements Processor {
    private Change change;
    ChangeAdapter(Change change){
        this.change = change;
    }
    @Override
    public String process(Object input) {
        return change.process((String)input);
    }
    @Override
    public String name() {
        return "ChangeAdapter";
    }
}
