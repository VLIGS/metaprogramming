
class SpringOneExpando {
    protected dynamicProps = [:] //this is just creating standard protected field in this class, which is initialised to empty map
    void setProperty(String propName, val){ //every time setProperty is called
            dynamicProps[propName] = val    //put new entry into a map with key in propName variable and value in variable val
    }

    def getProperty(String propName){
        dynamicProps[propName]  //return whatever value is in the map that is associated with value in propName variable
    }

    def methodMissing(String methodName, args){
        def prop = dynamicProps[methodName]
        if(prop instanceof Closure){
            return prop(*args)
        }
    }
}
