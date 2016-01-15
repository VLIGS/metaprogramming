package VideoDemo

class ClosureDemo {

    void append(String args){
        println "Append Mathod Was Invoked With Arg: ${args}"
    }
    void doit(){
        def c = {
            append 'Line One\n'
            append 'Line Two\n'
        }

        sb = new StringBuffer()
        c.delegate = sb //every closure has delegate associated with it, the delegate gets opportunity to respond to method calls
                        //that are made while closure is executing
                        //delegate gets to participate only if there is no 'append' method defined in the actual class
                        //every closure also has c.owner, whose value is the value of the class which created this closure
                        //owner gets opportunity to respond to method calls that are made while closure is executing
                        //owner takes a priority over delegate
        c.resolveStrategy = Closure.OWNER_FIRST //this ensures that owner takes priority, and this is default setting
                        //= Closure.DELEGATE_FIRST //this ensures that delegate takes priority
        c()
        println "Buffer: ${sb}"
    }
    static void main(args){
        new ClosureDemo().doit()
    }
}
