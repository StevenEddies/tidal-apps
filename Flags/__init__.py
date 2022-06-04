from tidal import *
from app import App
from buttons import Buttons

class FlagsApp(App):
	
	def __init__(self):
		super().__init__()
		self.mybuttons = Buttons()
		self.current_index = 0
		self.flags = [
			self.draw_rainbow,
			self.draw_ace
		]
	
	def on_activate(self):
		super().on_activate()
		self.draw_current()
	
	def on_start(self):
		super().on_start()
		self.mybuttons.on_press(JOY_RIGHT, self.next_flag)
	
	def next_flag(self):
		self.current_index = (self.current_index + 1) % len(self.flags)
		self.draw_current()
	
	def draw_current(self):
		self.flags[self.current_index]()
	
	def draw_rainbow(self):
		display.fill(color565(228, 3, 3))
		display.fill_rect(22, 0, 23, 240, color565(255, 140, 0))
		display.fill_rect(45, 0, 22, 240, color565(255, 237, 0))
		display.fill_rect(67, 0, 23, 240, color565(0, 128, 38))
		display.fill_rect(90, 0, 22, 240, color565(0, 77, 255))
		display.fill_rect(112, 0, 23, 240, color565(117, 7, 135))
	
	def draw_ace(self):
		display.fill(color565(0, 0, 0))
		display.fill_rect(34, 0, 34, 240, color565(164, 165, 164))
		display.fill_rect(68, 0, 34, 240, color565(255, 255, 255))
		display.fill_rect(102, 0, 33, 240, color565(129, 0, 129))


main = FlagsApp
