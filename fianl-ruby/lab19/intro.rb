#Reference: http://ruby-doc.com/docs/ProgrammingRuby/

module RevString
    def to_rev_s
      to_s.reverse
    end
end

class Person # Re-opening class
    include RevString
    def to_s
      @name
    end
end

p.to_rev_s # p defined previously