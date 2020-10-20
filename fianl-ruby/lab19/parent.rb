class Dog
    def initialize(name)
        @name = name 
    end
    
    def speak
        puts "#{@name} says bark"
    end 
end
    
rex = Dog.new('Rex') 
rex.speak


class GuardDog < Dog  # Equivalent to extends in Java
    attr_reader :breed    # attr_reader you can only read the value, but not change it. 
    def initialize(name, breed)
        super(name)
        @breed = breed
    end

    def attack
        puts "Growl"
    end
end


satan = GuardDog.new('Satan', 'Doberman') 
puts "Satan is a #{satan.breed}" 
satan.speak
satan.attack