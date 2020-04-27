file = File.open('/Users/Git/cs152/day19/file/temp.txt', 'r');
file.each_line do |line|
    puts line
end
file.close;



