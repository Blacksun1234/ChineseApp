import json

r = open("exo1.json", "r", encoding="utf8")
data = json.loads(r.read())

w = open("exo1_good.json", "w", encoding="utf8")
good = []

#for obj in data:
#	good.append({
#		"hanzi": obj["Q1HZ"],
#		"pinyin": obj["Q1PY"],
#		"fr": obj["Q1FR"],
#		"correct": obj["bon choix"],
#		"choices": [
#			obj["choix 1"],
#			obj["choix 2"],
#			obj["choix 3"],
#			obj["choix 4"],
#		]
#	})

#theme = {}
#for obj in data:
#	t = obj["theme"]
#	del obj["theme"]
#	if t not in theme:
#		theme[t] = [obj]
#	else:
#		theme[t].append(obj)
#
#for key, val in theme.items():
#	good.append({
#		"theme": key,
#		"words": val
#	})

json.dump(good, w, ensure_ascii=False, indent=4)