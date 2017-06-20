package precipitated.will.concurrent.producerandconsumer.condition;

/**
 * Created by will.wang on 2015/10/31.
 */
public class MockFile {

    private String[] content;

    private int index;

    public MockFile(String[] content) {
        this.content = content;
        this.index = 0;
    }

    public boolean hasMoreLines() {
        return index < content.length;
    }

    public String getLine() {
        if(hasMoreLines()) {
            return content[index++];
        }
        return null;
    }
}
