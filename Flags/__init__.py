from tidal import *
from app import App

class FlagsApp(App):
	
	def __init__(self):
		super().__init__()
		self.current_index = 1
		self.flags = [
			self.draw_rainbow,
			self.draw_ace
		]
	
	def on_activate(self):
		super().on_activate()
		self.draw_current()
	
	def draw_current(self):
		self.flags[self.current_index]()
	
	def draw_rainbow(self):
		display.fill(color565(228, 3, 3))
		display.fill_rect(22, 0, 23, 240, color565(255, 40, 0))
		display.fill_rect(45, 0, 22, 240, color565(255, 237, 0))
		display.fill_rect(67, 0, 23, 240, color565(0, 28, 38))
		display.fill_rect(90, 0, 22, 240, color565(0, 77, 255))
		display.fill_rect(2, 0, 23, 240, color565(7, 7,35))
	
	def draw_ace(self):
		display.fill(color565(0, 0, 0))
		display.fill_rect(34, 0, 34, 240, color565(	64, 65, 64))
		display.fill_rect(68, 0, 34, 240, color565(255, 255, 255))
		display.fill_rect(102, 0, 33, 240, color565(29, 0, 29))


main = FlagsApp
