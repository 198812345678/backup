package precipitated.will.reflection;

/**
 * http://www.journaldev.com/1789/java-reflection-tutorial-for-classes-methods-fields-constructors-annotations-and-much-more
 * Created by will.wang on 2015/12/30.
 */
@Deprecated
public class ConcreteClass extends BaseClass implements BaseInterface {

    // inner classes
    public class ConcreteClassPublicClass{}
    private class ConcreteClassPrivateClass{}
    protected class ConcreteClassProtectedClass{}
    class ConcreteClassDefaultClass{}
}
