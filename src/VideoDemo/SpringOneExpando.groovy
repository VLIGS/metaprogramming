package VideoDemo
/**
 * this shows participation in Groovy dynamic dispatch, any time someone assigns a value to a property on an instance of this class
 * let me participate in that, same for any time someone tries to retrieve value of the property in instance of this class
 * and if someone invokes a method that does nor exist, let me participate
 */
class SpringOneExpando {
    protected dynamicProps = [:] //this is just creating standard protected field in this class, which is initialised to empty map
    void setProperty(String propName, val){ //every time setProperty is called
            dynamicProps[propName] = val    //put new entry into a map with key in propName variable and value in variable val
    }

    def getProperty(String propName){
        dynamicProps[propName]  //return whatever value is in the map that is associated with value in propName variable
    }

    def methodMissing(String methodName, args){ //if this method is implemented in any class in Groovy, then Groovy
                                                //will invoke methodMissing with first argument to this method being a String
                                                //which represents a name of the method, second is and object array that
                                                //includes all the arguments that are passed in method invocation
        def prop = dynamicProps[methodName]     //this will assign Closure under name methodName from properties map to prop
        if(prop instanceof Closure){
            return prop(*args)                  //invoke the Closure and pass arguments into it
                                                //where * is spread operator, which ensures that individual elements of args array
                                                //are passed into this closure
        }
    }
}
