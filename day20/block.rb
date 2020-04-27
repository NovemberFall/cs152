# 内部迭代器
[1, 2, 3].each {|x| puts x }

# 用f(x) = x * 2将原集合映射到一个新集合
[1, 2, 3].map {|x| x * 2 }
# 挑选出一个集合里的所有奇数
[1, 2, 3].select {|x| x%2 != 0 }
# 动态定义一个问候方法
define_method :greet do |name|
  puts "hello, #{name}"
end



