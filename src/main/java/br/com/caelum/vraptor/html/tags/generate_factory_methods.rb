Dir.new('.').sort.each do |filename|
	if filename.match(/.+\.java/)
		classname = filename.gsub(/\.java/, '')
		puts "public static #{classname} #{classname.downcase}(Attribute... attributes) {\nreturn new #{classname}(attributes);\n}\n"
	end
end
