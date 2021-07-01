//6.Dodaj siebie do bazy, zgodnie z formatem danych użytych dla innych osób (dane dotyczące karty kredytowej, adresu zamieszkania i wagi mogą być fikcyjne); 
printjson(db.people.insertOne({
    "sex" : "Male",
	"first_name" : "Elaa",
	"last_name" : "Elaaaa tututuru",
	"job" : "Geological Engineer",
	"email" : "ganderson1@netscape.com",
	"location" : {
		"city" : "Caminaca",
		"address" : {
			"streetname" : "Kipling",
			"streetnumber" : "424"
		}
	},
	"description" : "donec posuere metus vitae ipsum aliquam non mauris morbi non lectus aliquam sit amet diam in",
	"height" : "154.61",
	"weight" : "67.3",
	"birth_date" : "2002-09-27T05:44:11Z",
	"nationality" : "Peru",
	"credit" : [
		{
			"type" : "laser",
			"number" : "5586087121891962",
			"currency" : "IDR",
			"balance" : "5512.36"
		},
		{
			"type" : "bankcard",
			"number" : "5010120787942724",
			"currency" : "CNY",
			"balance" : "5190.65"
		},
		{
			"type" : "mastercard",
			"number" : "201768421731919",
			"currency" : "CNY",
			"balance" : "6414.82"
		},
		{
			"type" : "americanexpress",
			"number" : "3582797025806663",
			"currency" : "CDF",
			"balance" : "6365.42"
		},
		{
			"type" : "jcb",
			"number" : "6376881458117617",
			"currency" : "PLN",
			"balance" : "5408.84"
		}
	]
}))