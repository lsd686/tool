# encoding: GBK
require './readExcel'

folder = 'D:/yJstudy/semester/a2015-16/I/exam/'
Dir.open(folder) do |dir|
  dir.each { |file|
    if /xls/ =~ file
      # puts folder + file.to_s.encode('UTF-8')
      prt_match_rows_in_excel(folder + file.to_s.encode('UTF-8'))
    end }
end
