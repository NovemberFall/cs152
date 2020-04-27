class Person
    def initialize name # Constructor
        @name = name
    end

    def name            # Getter
        return @name
    end

    def name = newName # setter
        @name = newName
    end

    def say_hi          # Method
        puts "Hello, my name is #{@name}."
    end
end

# p = Person.new "Joe"
# puts "Name is #{p.name}"
# p.say_hi


