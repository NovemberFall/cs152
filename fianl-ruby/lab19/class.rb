class Person
    def initialize name # Constructor
        @name = name   #@ indicates an object's field
    end
    
    def name       # Getter
        return @name
    end
    
    def name= newName   # Setter
        @name = newName
    end
    
    def say_hi         # Method
        puts "Hello, my name is #{@name}."
    end 
end