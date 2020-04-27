class Dog
    def initialize(name)
        @name = name
    end

    def speak
        puts "#{@name} says bark"
    end
end

rex = Dog.new('Rex');
rex.speak;