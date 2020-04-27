def name
    puts "A yield will be called with id of 12"
    yield 12
    puts "A yield will be called with id of 14"
    yield 14
end


name {|i| puts "I am called by yield name #{i}"}







def load_game
    puts "Loading"

    yield

end


load_game { puts "Game loaded" }









puts "\n";

class Array
    def my_each
      i = 0
      if block_given?
        while i < self.size
          yield self[i]
          i += 1
        end
      end
      self
    end
end
[1, 2, 3].my_each {|x| puts x }