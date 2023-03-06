#1600 year Calander in opps
import subprocess

class NotValidMonth(Exception):
	def __init__(self, msg="Not a Valid Month."):
		print(msg)

class NotValidDate(Exception):
	def __init__(self, msg="Not a Valid Date."):
		print(msg)
	def __str__():
			"Not a Valid Dateeee."

class Date:
	def __init__ (self,year, month, day):
		year=Date.chk_year(year)
		month=Date.chk_month(month)	
		day=Date.chk_day(year, month, day)
		if day>0:
			Date.year=year
			Date.month=month
			Date.day=day
		else:
			raise NotValidDate
			
	def __str__(self):
			return "Day: {}Month:{} Year: {} ".format(Date.day, Date.month, Date.year )
	#	return "Year: {} Month: {} Day: {}".format(Date.year, Date.month, Date.day)
	
	@staticmethod
	def chk_year(year):
		"""year Enter Loop"""
		try:
			year=int(year)
		except:
			input("Sting not allowed only numeric value alowed.")
			return False
		else:	
			if year >0:
				return year
			else:
				print("Not Valid year.")		
			
	@staticmethod
	def chk_month(month):
		"""Month Enter Loop"""
		month_name_short=['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'July', 'Aug', 'Sep', 'Oct', 'Nov', 'Des']
		month_names_full=["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"]
		try:
			month=int(month)
			if (month>=1 and month<=12 ): 
				return month
			else:
				print("Please, Enter Curret Month (1 to 12).")
				return False
		except ValueError:
			try:
				index=month_names_full.index(month.title())
				return index+1
			except ValueError:
				try:
					index=month_name_short.index(month.title())
					return index+1
				except:
					print("Not valid month name.Prease any key for input angin.")
					return False		
			
	@staticmethod
	def chk_day(year, month, day):
		"""day Enter Loop"""
		try:
			day=int(day)
		except ValueError:
			print("Sting not allowed only numeric value alowed.")
			return False
		else:
			if month==2:
				day_limit=(28,29) [Date.check_leep(year)]		#turnary operator for fuburay days set
			elif month>=1 and month <=12:
				day_limit=(30,31)[month in [1,3,5,7,9,11]]		#turnary operator for day-limit 30 or 31 days set
			else:
				return False
			if day>=1 and day<=day_limit:
				return day
			else:
				print(f'Please, Enter Currect Day (1 to {day_limit}).')
				return False

	@staticmethod
	def check_leep(year):
		#check leep year
		return (False, True) [year%4==0 and ((year%100!=0) or year%400==0)]
		# not Leep year [1700, 1800, 1900, 2100, 2200, 2300, 2500, 2600, 1900]:
		#Leep Year [1600, 2000, 2400]


"""calender class definetion"""
class Calender:
	_month_Name={1:'Jan', 2:'Feb', 3:'Mar', 4:'Apr', 5:'May', 6:'Jun', 7:'July', 8:'Aug', 9:'Sep', 10:'Oct', 11:'Nov', 12:'Dec'}	
	def __init__(self):
		self._day_name=['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat']
		self._year_code=[6,4,2,0]	#year_code[(year//100)%4]
		self._month_L_Year=[0,3,3,6,1,4,6,2,5,0,3,5]
		self._month_N_Year=[6,2,3,6,1,4,6,2,5,0,3,5]
		
	@staticmethod
	def _clr_scr():
		subprocess.run('clear', check=False)
	
	def gat_day_name(self, date=(0,0,0)): 
		if type(date)==Date:
			self._date_calculation(date)
			return self.get_day
		elif date[0]!=0 and date[1]!=0 and date[2]!=0:
			date=Date(date[0], date[1], date[2])
			if type(date)==Date:
				self._date_calculation(date)
				return self.get_day
			else:
				return
		else:
			date=self._input_date()
			self._date_calculation(date)
			return self.get_day
			
	def _input_date(self):
		#year Enter Loop
		while True :
			Calender._clr_scr()
			year=input("Enter Date: \nEnter Year:\t")
			if Date.chk_year(year):
				year=int(year)
				break
			else:
				continue
		while True:
			Calender._clr_scr()
			month=input(f'{Calender._month_Name}\nEnter Date: \nEnter Month\t')
			if Date.chk_month(month):
				month=int(month)
				break
			else:
				continue
				
		while True:
			Calender._clr_scr()
			day=input("Enter Date: \nEnter Day\t")
			if Date.chk_day(year, month, day):
				day=int(day)
				break
			else:
				continue
	
		date=Date(year, month, day)
		return date				
	def _date_calculation(self, date):
		#month code
		month_code=((self._month_L_Year[date.month-1], self._month_N_Year[date.month-1]) [Date.check_leep(date.year)])
		#year code
		year=str(date.year)
		year='0'*(4-len(year))+year		#minimum 4 digit 0 conversion
		s_y=int(year[:-2])	#start digit of year
		e_y=int(year[-2:]) #end 2 digit of year
		print(f"day on :{date.day}, {Calender._month_Name[date.month]}, on year {year} is:", end='\t')
		#(date+Month_code+century_code+Last two digit of year+(Last Two digit of year//4))%7
		self.get_day = self._day_name[( date.day + month_code + self._year_code [s_y%4] + e_y + (e_y//4)) % 7 ]
		print(self.get_day)
c=Calender()
#check date 

c.gat_day_name((2023,2,27))
c.gat_day_name((2023,"fEb",28))
try:
	c.gat_day_name((2023,32,2))
except NotValidDate or NotValidMonth:
	pass
try:
	c.gat_day_name((2023,2,64))
except NotValidDate or NotValidMonth:
	pass
c.gat_day_name()
input()
c.gat_day_name((2023,3,2))
print(Date.check_leep((2024)))
"""ther have 3 method to use this Clander class
1) by input by user
2)by give data class value
3) by provide value in upple or list """
#c.gat_day_name() 			# Example of method 1
date=Date(2023,2,4)
print(date)
c.gat_day_name(date)	# Example of method 2
c.gat_day_name((8989778658778627866,"mar",3))		# Example of method 3
date2=Date(month=2, day=12, year=2032)


print(date2)