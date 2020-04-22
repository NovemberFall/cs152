"adventure" by "Yuxiao Zheng"

When play begins: say "Hello Inform7. I begin a adventure game by using inform7.
	During coronavirus, playing a game is a good choice."

[A event can be examined or unexamined. A thing is usually unexamined. After examining something: now the noun is examined; continue the action.]
[A thing can be examined or unexamined. A thing is unexamined. After examining something: now the noun is examined.]

The Study is a room. "Fresh air and Bright sunlight pours in through the window."

The iPhone is in the Study. Description is "[if player is in study]You check your iPhone. you look at your phone, it is too late! Good thing there's still time to get to school. School is to the west.[otherwise]You're far behind schedule, better get moving!"

The laptop is in the Study. Description is "[if player is in study and player does not have laptop]Your laptop is lying around. [end if] MacOS is starting. This is where the computer networking happens. [if player is in Cyber Room] A few terminal windows are tiled to the screen corners, with green text flows across them. Since when did you use green text? Something tells you that computer networking is happening."

The charger is in the Study. Description is "[if player is in Study and player does not have charger]Your laptop charger is lying around. Don't forget to take it with you![otherwise]Good thing you brought your laptop charger."

[Every turn:
	If the iPhone is unexamined:
		Instead of going west:
			say "Why would you go to school right now? You should check your iPhone first.";]

[Instead of going west:
	say "You'd better get oriented first.";]

Every turn:
	If player is in Study:
		if player does not have iPhone:
			say "You feel a lack of grasp on the time. Where's your iPhone?";
		if player does not have laptop:
			say "Your backpack feels unusually light.";
		if player does not have charger:
			say "Something doesn't feel right.";
	If player is in SJSU:
		if player does not have laptop or player does not have charger:
			say "You feel unprepared."
	[Otherwise:]

The SJSU is a room. Description is "[if unvisited]You go to school, You driving your car to MacQuarrie Hall. This is [end if]SJSU, a college in Silicon Valley with a long history, stuck in the middle of downtown San Jose. " The SJSU is west of the Home.



Example Location is a room.