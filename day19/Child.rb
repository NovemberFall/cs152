class Dog
    def initialize(name)
        @name = name
    end

    def speak
        puts "#{@name} says bark"
    end
end


class GuardDog < Dog        #Equivalent to extends in Java
    attr_reader :breed
    def initialize(name, breed)
        super(name)
        @breed = breed
    end

    def attack
        puts "Growl"
    end
end

satan = GuardDog.new('Satan', 'Doberman');
puts "Santan is a #{satan.breed}"
satan.speak
satan.attack

