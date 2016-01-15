ex = new Expando()
ex.homeTown = 'LND' //this is not standard practice for groove, but specific feature of Expando class
                    //for Expando class and not just for any class, can just make up a property and assign a value to it
                    //here we are assigning a value to property that doesn't exist
                    //this is equivalent of calling ex.setProperty(homeTown, 'LND')

println "Home town: ${ex.homeTown}" // //this is equivalent of calling ex.getProperty(homeTown, 'LND')

