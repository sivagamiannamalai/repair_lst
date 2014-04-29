$(document).ready(function(){
	populateMakeAndModel();
	$("#createVehicleSubmit").click(createVehicle);
});

 function populateMakeAndModel() {
var modelMakeJsonList = {"modelMakeTable" : 
        [
				{"modelMakeID" : "ASTON MARTIN","modelMake" : "ASTON MARTIN"},
				{"modelMakeID" : "AUDI","modelMake" : "AUDI"},
				{"modelMakeID" : "BENTLEY","modelMake" : "BENTLEY"},
				{"modelMakeID" : "BMW","modelMake" : "BMW"},
				{"modelMakeID" : "BUGATTI","modelMake" : "BUGATTI"},
				{"modelMakeID" : "DAIMLERCHRYSLER","modelMake" : "DAIMLERCHRYSLER"},
				{"modelMakeID" : "FERRARI","modelMake" : "FERRARI"},
				{"modelMakeID" : "FORD","modelMake" : "FORD"},
				{"modelMakeID" : "FUJI","modelMake" : "FUJI"},
				{"modelMakeID" : "GM","modelMake" : "GM"},
				{"modelMakeID" : "HONDA","modelMake" : "HONDA"},
				{"modelMakeID" : "HYUNDAI","modelMake" : "HYUNDAI"},
				{"modelMakeID" : "JAGUAR","modelMake" : "JAGUAR"},
				{"modelMakeID" : "KIA","modelMake" : "KIA"},
				{"modelMakeID" : "LAMBORGHINI","modelMake" : "LAMBORGHINI"},
				{"modelMakeID" : "LAND ROVER","modelMake" : "LAND ROVER"},
				{"modelMakeID" : "LOTUS","modelMake" : "LOTUS"},
				{"modelMakeID" : "MASERATI","modelMake" : "MASERATI"},
				{"modelMakeID" : "MAZDA","modelMake" : "MAZDA"},
				{"modelMakeID" : "MERCEDES BENZ","modelMake" : "MERCEDES BENZ"},
				{"modelMakeID" : "MITSUBISHI","modelMake" : "MITSUBISHI"},
				{"modelMakeID" : "NUMMI","modelMake" : "NUMMI"},
				{"modelMakeID" : "NISSAN","modelMake" : "NISSAN"},
				{"modelMakeID" : "PORSCHE","modelMake" : "PORSCHE"},
				{"modelMakeID" : "ROLLS-ROYCE","modelMake" : "ROLLS-ROYCE"},
				{"modelMakeID" : "ROUSH","modelMake" : "ROUSH"},
				{"modelMakeID" : "SUZUKI","modelMake" : "SUZUKI"},
				{"modelMakeID" : "TESLA","modelMake" : "TESLA"},
				{"modelMakeID" : "TOYOTA","modelMake" : "TOYOTA"},
				{"modelMakeID" : "VOLKSWAGEN","modelMake" : "VOLKSWAGEN"},
				{"modelMakeID" : "VOLVO","modelMake" : "VOLVO"},
        ]};
var modelTypeJsonList = {"ASTON MARTIN" : 
        [
			{"modelTypeID" : "DB9 COUPE","modelType" : "DB9 COUPE"},
			{"modelTypeID" : "DB9 COUPE MANUAL","modelType" : "DB9 COUPE MANUAL"},
			{"modelTypeID" : "DB9 VOLANTE","modelType" : "DB9 VOLANTE"},
			{"modelTypeID" : "V12 VANQUISH S","modelType" : "V12 VANQUISH S"},
			{"modelTypeID" : "V8 VANTAGE","modelType" : "V8 VANTAGE"}
        ],
        "AUDI" : 
        [
			{"modelTypeID" : "A3","modelType" : "A3"},
			{"modelTypeID" : "A4","modelType" : "A4"},
			{"modelTypeID" : "A4 AVANT QUATTRO","modelType" : "A4 AVANT QUATTRO"},
			{"modelTypeID" : "A4 CABRIOLET","modelType" : "A4 CABRIOLET"},
			{"modelTypeID" : "A4 CABRIOLET QUATTRO","modelType" : "A4 CABRIOLET QUATTRO"},
			{"modelTypeID" : "A4 QUATTRO","modelType" : "A4 QUATTRO"},
			{"modelTypeID" : "A6","modelType" : "A6"},
			{"modelTypeID" : "A6 AVANT QUATTRO","modelType" : "A6 AVANT QUATTRO"},
			{"modelTypeID" : "A6 QUATTRO","modelType" : "A6 QUATTRO"},
			{"modelTypeID" : "A8 L","modelType" : "A8 L"},
			{"modelTypeID" : "GTI","modelType" : "GTI"},
			{"modelTypeID" : "PASSAT","modelType" : "PASSAT"},
			{"modelTypeID" : "S4","modelType" : "S4"},
			{"modelTypeID" : "S4 AVANT","modelType" : "S4 AVANT"},
			{"modelTypeID" : "S4 CABRIOLET","modelType" : "S4 CABRIOLET"},
			{"modelTypeID" : "TT COUPE","modelType" : "TT COUPE"},
			{"modelTypeID" : "TT ROADSTER","modelType" : "TT ROADSTER"}
        ],
        "BENTLEY" : 
        [
			{"modelTypeID" : "BENTLEY ARNAGE","modelType" : "BENTLEY ARNAGE"},
			{"modelTypeID" : "CONTINENTAL FLYING SPUR","modelType" : "CONTINENTAL FLYING SPUR"},
			{"modelTypeID" : "CONTINENTAL GT","modelType" : "CONTINENTAL GT"}
        ],
        "BMW" : 
        [
			{"modelTypeID" : "325CI CONVERTIBLE","modelType" : "325CI CONVERTIBLE"},
			{"modelTypeID" : "325I","modelType" : "325I"},
			{"modelTypeID" : "325XI","modelType" : "325XI"},
			{"modelTypeID" : "325XI SPORT WAGON","modelType" : "325XI SPORT WAGON"},
			{"modelTypeID" : "330CI CONVERTIBLE","modelType" : "330CI CONVERTIBLE"},
			{"modelTypeID" : "330I","modelType" : "330I"},
			{"modelTypeID" : "330XI","modelType" : "330XI"},
			{"modelTypeID" : "525I","modelType" : "525I"},
			{"modelTypeID" : "525XI","modelType" : "525XI"},
			{"modelTypeID" : "530I","modelType" : "530I"},
			{"modelTypeID" : "530XI","modelType" : "530XI"},
			{"modelTypeID" : "530XI SPORT WAGON","modelType" : "530XI SPORT WAGON"},
			{"modelTypeID" : "550I","modelType" : "550I"},
			{"modelTypeID" : "650CI","modelType" : "650CI"},
			{"modelTypeID" : "650CI CONVERTIBLE","modelType" : "650CI CONVERTIBLE"},
			{"modelTypeID" : "750LI","modelType" : "750LI"},
			{"modelTypeID" : "760LI","modelType" : "760LI"},
			{"modelTypeID" : "M3","modelType" : "M3"},
			{"modelTypeID" : "M3 CONVERTIBLE","modelType" : "M3 CONVERTIBLE"},
			{"modelTypeID" : "M5","modelType" : "M5"},
			{"modelTypeID" : "M6","modelType" : "M6"},
			{"modelTypeID" : "MINI COOPER","modelType" : "MINI COOPER"},
			{"modelTypeID" : "MINI COOPER CONVERTIBLE","modelType" : "MINI COOPER CONVERTIBLE"},
			{"modelTypeID" : "MINI COOPER S","modelType" : "MINI COOPER S"},
			{"modelTypeID" : "MINI COOPER S CONVERTIBLE","modelType" : "MINI COOPER S CONVERTIBLE"},
			{"modelTypeID" : "X3","modelType" : "X3"},
			{"modelTypeID" : "X5","modelType" : "X5"},
			{"modelTypeID" : "X5 4.8IS","modelType" : "X5 4.8IS"},
			{"modelTypeID" : "Z4 3.0 SI COUPE","modelType" : "Z4 3.0 SI COUPE"},
			{"modelTypeID" : "Z4 3.0I","modelType" : "Z4 3.0I"},
			{"modelTypeID" : "Z4 3.0SI","modelType" : "Z4 3.0SI"},
			{"modelTypeID" : "Z4 M ROADSTER","modelType" : "Z4 M ROADSTER"}
        ],
        "BUGATTI" : 
        [
			{"modelTypeID" : "VEYRON","modelType" : "VEYRON"}
        ],
        "DAIMLERCHRYSLER" : 
        [
			{"modelTypeID" : "300C/SRT-8","modelType" : "300C/SRT-8"},
			{"modelTypeID" : "CARAVAN 2WD","modelType" : "CARAVAN 2WD"},
			{"modelTypeID" : "CHARGER","modelType" : "CHARGER"},
			{"modelTypeID" : "COMMANDER 4WD","modelType" : "COMMANDER 4WD"},
			{"modelTypeID" : "CROSSFIRE ROADSTER","modelType" : "CROSSFIRE ROADSTER"},
			{"modelTypeID" : "DAKOTA PICKUP 2WD","modelType" : "DAKOTA PICKUP 2WD"},
			{"modelTypeID" : "DAKOTA PICKUP 4WD","modelType" : "DAKOTA PICKUP 4WD"},
			{"modelTypeID" : "DURANGO 2WD","modelType" : "DURANGO 2WD"},
			{"modelTypeID" : "DURANGO 4WD","modelType" : "DURANGO 4WD"},
			{"modelTypeID" : "GRAND CHEROKEE 2WD","modelType" : "GRAND CHEROKEE 2WD"},
			{"modelTypeID" : "GRAND CHEROKEE 4WD","modelType" : "GRAND CHEROKEE 4WD"},
			{"modelTypeID" : "LIBERTY/CHEROKEE 2WD","modelType" : "LIBERTY/CHEROKEE 2WD"},
			{"modelTypeID" : "LIBERTY/CHEROKEE 4WD","modelType" : "LIBERTY/CHEROKEE 4WD"},
			{"modelTypeID" : "PACIFICA 2WD","modelType" : "PACIFICA 2WD"},
			{"modelTypeID" : "PACIFICA AWD","modelType" : "PACIFICA AWD"},
			{"modelTypeID" : "PT CRUISER","modelType" : "PT CRUISER"},
			{"modelTypeID" : "RAM 1500 PICKUP 2WD","modelType" : "RAM 1500 PICKUP 2WD"},
			{"modelTypeID" : "RAM 1500 PICKUP 4WD","modelType" : "RAM 1500 PICKUP 4WD"},
			{"modelTypeID" : "SEBRING 4-DR","modelType" : "SEBRING 4-DR"},
			{"modelTypeID" : "STRATUS 4-DR","modelType" : "STRATUS 4-DR"},
			{"modelTypeID" : "TOWN & COUNTRY 2WD","modelType" : "TOWN & COUNTRY 2WD"},
			{"modelTypeID" : "VIPER CONVERTIBLE","modelType" : "VIPER CONVERTIBLE"},
			{"modelTypeID" : "WRANGLER/TJ 4WD","modelType" : "WRANGLER/TJ 4WD"}
        ],
        "FERRARI" : 
        [
			{"modelTypeID" : "F430","modelType" : "F430"},
			{"modelTypeID" : "FERRARI 612 SCAGLIETTI","modelType" : "FERRARI 612 SCAGLIETTI"},
			{"modelTypeID" : "FERRARI F141","modelType" : "FERRARI F141"}
        ],
        "FORD" : 
        [
			{"modelTypeID" : "B4000 4WD","modelType" : "B4000 4WD"},
			{"modelTypeID" : "CROWN VICTORIA POLICE","modelType" : "CROWN VICTORIA POLICE"},
			{"modelTypeID" : "E150 CLUB WAGON","modelType" : "E150 CLUB WAGON"},
			{"modelTypeID" : "E150 ECONOLINE 2WD","modelType" : "E150 ECONOLINE 2WD"},
			{"modelTypeID" : "ESCAPE 4WD","modelType" : "ESCAPE 4WD"},
			{"modelTypeID" : "ESCAPE FWD","modelType" : "ESCAPE FWD"},
			{"modelTypeID" : "ESCAPE HYBRID 4WD","modelType" : "ESCAPE HYBRID 4WD"},
			{"modelTypeID" : "ESCAPE HYBRID FWD","modelType" : "ESCAPE HYBRID FWD"},
			{"modelTypeID" : "EXPEDITION 2WD","modelType" : "EXPEDITION 2WD"},
			{"modelTypeID" : "EXPLORER 2WD","modelType" : "EXPLORER 2WD"},
			{"modelTypeID" : "EXPLORER 4WD","modelType" : "EXPLORER 4WD"},
			{"modelTypeID" : "F150 FFV  2WD","modelType" : "F150 FFV  2WD"},
			{"modelTypeID" : "F150 FFV  4WD","modelType" : "F150 FFV  4WD"},
			{"modelTypeID" : "F150 PICKUP 2WD","modelType" : "F150 PICKUP 2WD"},
			{"modelTypeID" : "F150 PICKUP 4WD","modelType" : "F150 PICKUP 4WD"},
			{"modelTypeID" : "FIVE HUNDRED AWD","modelType" : "FIVE HUNDRED AWD"},
			{"modelTypeID" : "FIVE HUNDRED FWD","modelType" : "FIVE HUNDRED FWD"},
			{"modelTypeID" : "FOCUS  FWD","modelType" : "FOCUS  FWD"},
			{"modelTypeID" : "FOCUS STATION WAG","modelType" : "FOCUS STATION WAG"},
			{"modelTypeID" : "FREESTAR WAGON FWD","modelType" : "FREESTAR WAGON FWD"},
			{"modelTypeID" : "FREESTYLE AWD","modelType" : "FREESTYLE AWD"},
			{"modelTypeID" : "FREESTYLE FWD","modelType" : "FREESTYLE FWD"},
			{"modelTypeID" : "GRAND MARQUIS","modelType" : "GRAND MARQUIS"},
			{"modelTypeID" : "GT        2WD","modelType" : "GT        2WD"},
			{"modelTypeID" : "LS","modelType" : "LS"},
			{"modelTypeID" : "MARK LT","modelType" : "MARK LT"},
			{"modelTypeID" : "MILAN","modelType" : "MILAN"},
			{"modelTypeID" : "MONTEREY WAGON FWD","modelType" : "MONTEREY WAGON FWD"},
			{"modelTypeID" : "MOUNTAINEER 4WD","modelType" : "MOUNTAINEER 4WD"},
			{"modelTypeID" : "MUSTANG","modelType" : "MUSTANG"},
			{"modelTypeID" : "NAVIGATOR 2WD","modelType" : "NAVIGATOR 2WD"},
			{"modelTypeID" : "RANGER PICKUP 2WD","modelType" : "RANGER PICKUP 2WD"},
			{"modelTypeID" : "RANGER PICKUP 4WD","modelType" : "RANGER PICKUP 4WD"},
			{"modelTypeID" : "TAURUS","modelType" : "TAURUS"},
			{"modelTypeID" : "TAURUS ETHANOL FFV","modelType" : "TAURUS ETHANOL FFV"},
			{"modelTypeID" : "THUNDERBIRD","modelType" : "THUNDERBIRD"},
			{"modelTypeID" : "TOWN CAR","modelType" : "TOWN CAR"},
			{"modelTypeID" : "ZEPHYR","modelType" : "ZEPHYR"}
        ],
        "FUJI" : 
        [
			{"modelTypeID" : "B9 TRIBECA AWD","modelType" : "B9 TRIBECA AWD"},
			{"modelTypeID" : "BAJA AWD","modelType" : "BAJA AWD"},
			{"modelTypeID" : "FORESTER AWD","modelType" : "FORESTER AWD"},
			{"modelTypeID" : "IMPREZA AWD","modelType" : "IMPREZA AWD"},
			{"modelTypeID" : "IMPREZA WGN/OUTBACK SPT AWD","modelType" : "IMPREZA WGN/OUTBACK SPT AWD"},
			{"modelTypeID" : "LEGACY AWD","modelType" : "LEGACY AWD"},
			{"modelTypeID" : "LEGACY WAGON AWD","modelType" : "LEGACY WAGON AWD"},
			{"modelTypeID" : "OUTBACK AWD","modelType" : "OUTBACK AWD"},
			{"modelTypeID" : "OUTBACK WAGON AWD","modelType" : "OUTBACK WAGON AWD"}
        ],
        "GM" : 
        [
			{"modelTypeID" : "9-3 CONVERTIBLE","modelType" : "9-3 CONVERTIBLE"},
			{"modelTypeID" : "9-3 SPORT SEDAN","modelType" : "9-3 SPORT SEDAN"},
			{"modelTypeID" : "9-5 SEDAN","modelType" : "9-5 SEDAN"},
			{"modelTypeID" : "C15 SILVERADO HYBRID 2WD","modelType" : "C15 SILVERADO HYBRID 2WD"},
			{"modelTypeID" : "C1500 SILVERADO 2WD","modelType" : "C1500 SILVERADO 2WD"},
			{"modelTypeID" : "C1500 SUBURBAN 2WD","modelType" : "C1500 SUBURBAN 2WD"},
			{"modelTypeID" : "C1500 TAHOE 2WD","modelType" : "C1500 TAHOE 2WD"},
			{"modelTypeID" : "C1500 YUKON 2WD","modelType" : "C1500 YUKON 2WD"},
			{"modelTypeID" : "COBALT","modelType" : "COBALT"},
			{"modelTypeID" : "COLORADO 2WD","modelType" : "COLORADO 2WD"},
			{"modelTypeID" : "COLORADO 4WD","modelType" : "COLORADO 4WD"},
			{"modelTypeID" : "COLORADO CAB CHASSIS INC 2WD","modelType" : "COLORADO CAB CHASSIS INC 2WD"},
			{"modelTypeID" : "COLORADO CREW CAB 2WD","modelType" : "COLORADO CREW CAB 2WD"},
			{"modelTypeID" : "COLORADO CREW CAB 4WD","modelType" : "COLORADO CREW CAB 4WD"},
			{"modelTypeID" : "CORVETTE","modelType" : "CORVETTE"},
			{"modelTypeID" : "CTS","modelType" : "CTS"},
			{"modelTypeID" : "DTS","modelType" : "DTS"},
			{"modelTypeID" : "ENVOY 2WD","modelType" : "ENVOY 2WD"},
			{"modelTypeID" : "ENVOY XL 4WD","modelType" : "ENVOY XL 4WD"},
			{"modelTypeID" : "EQUINOX AWD","modelType" : "EQUINOX AWD"},
			{"modelTypeID" : "EQUINOX FWD","modelType" : "EQUINOX FWD"},
			{"modelTypeID" : "ESCALADE 2WD","modelType" : "ESCALADE 2WD"},
			{"modelTypeID" : "ESCALADE ESV AWD","modelType" : "ESCALADE ESV AWD"},
			{"modelTypeID" : "G15/25CHEV VAN 2WD CONV","modelType" : "G15/25CHEV VAN 2WD CONV"},
			{"modelTypeID" : "G1500/2500 CHEVY EXPRESS 2WD","modelType" : "G1500/2500 CHEVY EXPRESS 2WD"},
			{"modelTypeID" : "G1500/2500 CHEVY VAN 2WD","modelType" : "G1500/2500 CHEVY VAN 2WD"},
			{"modelTypeID" : "G6","modelType" : "G6"},
			{"modelTypeID" : "G6 GT/GTP CONVERTIBLE","modelType" : "G6 GT/GTP CONVERTIBLE"},
			{"modelTypeID" : "GRAND PRIX","modelType" : "GRAND PRIX"},
			{"modelTypeID" : "GTO","modelType" : "GTO"},
			{"modelTypeID" : "H3 4WD","modelType" : "H3 4WD"},
			{"modelTypeID" : "HHR FWD","modelType" : "HHR FWD"},
			{"modelTypeID" : "I-280 2WD EXT CAB","modelType" : "I-280 2WD EXT CAB"},
			{"modelTypeID" : "IMPALA","modelType" : "IMPALA"},
			{"modelTypeID" : "K15 SILVERADO HYBRID 4WD","modelType" : "K15 SILVERADO HYBRID 4WD"},
			{"modelTypeID" : "K1500 AVALANCHE 4WD","modelType" : "K1500 AVALANCHE 4WD"},
			{"modelTypeID" : "K1500 SILVERADO 4WD","modelType" : "K1500 SILVERADO 4WD"},
			{"modelTypeID" : "K1500 TAHOE 4WD","modelType" : "K1500 TAHOE 4WD"},
			{"modelTypeID" : "LACROSSE/ALLURE","modelType" : "LACROSSE/ALLURE"},
			{"modelTypeID" : "LIMOUSINE","modelType" : "LIMOUSINE"},
			{"modelTypeID" : "MALIBU","modelType" : "MALIBU"},
			{"modelTypeID" : "MONTANA SV6 AWD","modelType" : "MONTANA SV6 AWD"},
			{"modelTypeID" : "MONTE CARLO","modelType" : "MONTE CARLO"},
			{"modelTypeID" : "RENDEZVOUS AWD","modelType" : "RENDEZVOUS AWD"},
			{"modelTypeID" : "RENDEZVOUS FWD","modelType" : "RENDEZVOUS FWD"},
			{"modelTypeID" : "SOLSTICE","modelType" : "SOLSTICE"},
			{"modelTypeID" : "SRX 2WD","modelType" : "SRX 2WD"},
			{"modelTypeID" : "SRX AWD","modelType" : "SRX AWD"},
			{"modelTypeID" : "SSR PICKUP 2WD","modelType" : "SSR PICKUP 2WD"},
			{"modelTypeID" : "STS","modelType" : "STS"},
			{"modelTypeID" : "STS AWD","modelType" : "STS AWD"},
			{"modelTypeID" : "TERRAZA FWD","modelType" : "TERRAZA FWD"},
			{"modelTypeID" : "TRAILBLAZER 2WD","modelType" : "TRAILBLAZER 2WD"},
			{"modelTypeID" : "TRAILBLAZER 4WD","modelType" : "TRAILBLAZER 4WD"},
			{"modelTypeID" : "TRAILBLAZER AWD","modelType" : "TRAILBLAZER AWD"},
			{"modelTypeID" : "TRAILBLAZER EXT 4WD","modelType" : "TRAILBLAZER EXT 4WD"},
			{"modelTypeID" : "UPLANDER FWD","modelType" : "UPLANDER FWD"},
			{"modelTypeID" : "VUE AWD","modelType" : "VUE AWD"},
			{"modelTypeID" : "VUE FWD","modelType" : "VUE FWD"},
			{"modelTypeID" : "XLR","modelType" : "XLR"},
			{"modelTypeID" : "AVEO","modelType" : "AVEO"},
			{"modelTypeID" : "FORENZA","modelType" : "FORENZA"},
			{"modelTypeID" : "FORENZA WAGON","modelType" : "FORENZA WAGON"},
			{"modelTypeID" : "VERONA","modelType" : "VERONA"}
        ],
        "HONDA" : 
        [
			{"modelTypeID" : "ACCORD","modelType" : "ACCORD"},
			{"modelTypeID" : "ACCORD HYBRID","modelType" : "ACCORD HYBRID"},
			{"modelTypeID" : "CIVIC","modelType" : "CIVIC"},
			{"modelTypeID" : "CIVIC HYBRID","modelType" : "CIVIC HYBRID"},
			{"modelTypeID" : "CR-V 2WD","modelType" : "CR-V 2WD"},
			{"modelTypeID" : "CR-V 4WD","modelType" : "CR-V 4WD"},
			{"modelTypeID" : "ELEMENT 2WD","modelType" : "ELEMENT 2WD"},
			{"modelTypeID" : "ELEMENT 4WD","modelType" : "ELEMENT 4WD"},
			{"modelTypeID" : "INSIGHT","modelType" : "INSIGHT"},
			{"modelTypeID" : "MDX 4WD","modelType" : "MDX 4WD"},
			{"modelTypeID" : "ODYSSEY 2WD","modelType" : "ODYSSEY 2WD"},
			{"modelTypeID" : "PILOT 2WD","modelType" : "PILOT 2WD"},
			{"modelTypeID" : "PILOT 4WD","modelType" : "PILOT 4WD"},
			{"modelTypeID" : "RIDGELINE 4WD","modelType" : "RIDGELINE 4WD"},
			{"modelTypeID" : "RL","modelType" : "RL"},
			{"modelTypeID" : "RSX","modelType" : "RSX"},
			{"modelTypeID" : "S2000","modelType" : "S2000"},
			{"modelTypeID" : "TL","modelType" : "TL"},
			{"modelTypeID" : "TSX","modelType" : "TSX"}
        ],
        "HYUNDAI" : 
        [
			{"modelTypeID" : "ACCENT","modelType" : "ACCENT"},
			{"modelTypeID" : "AZERA","modelType" : "AZERA"},
			{"modelTypeID" : "ELANTRA","modelType" : "ELANTRA"},
			{"modelTypeID" : "SANTAFE 2WD","modelType" : "SANTAFE 2WD"},
			{"modelTypeID" : "SANTAFE 4WD","modelType" : "SANTAFE 4WD"},
			{"modelTypeID" : "SONATA","modelType" : "SONATA"},
			{"modelTypeID" : "TIBURON","modelType" : "TIBURON"},
			{"modelTypeID" : "TUCSON 2WD","modelType" : "TUCSON 2WD"},
			{"modelTypeID" : "TUCSON 4WD","modelType" : "TUCSON 4WD"}
        ],
"JAGUAR" : 
        [
			{"modelTypeID" : "JAGUAR S-TYPE 3.0 LITRE","modelType" : "JAGUAR S-TYPE 3.0 LITRE"},
			{"modelTypeID" : "JAGUAR S-TYPE 4.2 LITRE","modelType" : "JAGUAR S-TYPE 4.2 LITRE"},
			{"modelTypeID" : "JAGUAR S-TYPE R","modelType" : "JAGUAR S-TYPE R"},
			{"modelTypeID" : "JAGUAR VDP LWB","modelType" : "JAGUAR VDP LWB"},
			{"modelTypeID" : "JAGUAR XJ8","modelType" : "JAGUAR XJ8"},
			{"modelTypeID" : "JAGUAR XK8 CONVERTIBLE","modelType" : "JAGUAR XK8 CONVERTIBLE"},
			{"modelTypeID" : "JAGUAR XKR CONVERTIBLE","modelType" : "JAGUAR XKR CONVERTIBLE"},
			{"modelTypeID" : "JAGUAR X-TYPE","modelType" : "JAGUAR X-TYPE"},
			{"modelTypeID" : "JAGUAR X-TYPE SPORT BRAKE","modelType" : "JAGUAR X-TYPE SPORT BRAKE"}
        ],
"KIA" : 
        [
			{"modelTypeID" : "KIA AMANTI","modelType" : "KIA AMANTI"},
			{"modelTypeID" : "KIA OPTIMA","modelType" : "KIA OPTIMA"},
			{"modelTypeID" : "KIA OPTIMA(MS)","modelType" : "KIA OPTIMA(MS)"},
			{"modelTypeID" : "KIA RIO","modelType" : "KIA RIO"},
			{"modelTypeID" : "KIA SEDONA","modelType" : "KIA SEDONA"},
			{"modelTypeID" : "KIA SORENTO 2WD","modelType" : "KIA SORENTO 2WD"},
			{"modelTypeID" : "KIA SORENTO 4WD","modelType" : "KIA SORENTO 4WD"},
			{"modelTypeID" : "KIA SPECTRA(LD)","modelType" : "KIA SPECTRA(LD)"},
			{"modelTypeID" : "KIA SPORTAGE 2WD","modelType" : "KIA SPORTAGE 2WD"},
			{"modelTypeID" : "KIA SPORTAGE 4WD","modelType" : "KIA SPORTAGE 4WD"}
        ],
        "LAMBORGHINI" : 
        [
			{"modelTypeID" : "L-140/715 GALLARDO","modelType" : "L-140/715 GALLARDO"},
			{"modelTypeID" : "L-147/148 MURCIELAGO","modelType" : "L-147/148 MURCIELAGO"}
        ],
        "LAND ROVER" : 
        [
			{"modelTypeID" : "LR3","modelType" : "LR3"},
			{"modelTypeID" : "RANGE ROVER","modelType" : "RANGE ROVER"},
			{"modelTypeID" : "RANGE ROVER SPORT","modelType" : "RANGE ROVER SPORT"}
        ],
        "LOTUS" : 
        [
			{"modelTypeID" : "ELISE","modelType" : "ELISE"},
			{"modelTypeID" : "EXIGE","modelType" : "EXIGE"}
        ],
        "MASERATI" : 
        [
			{"modelTypeID" : "COUPE CAMBIOCORSA/GT/G-SPORT","modelType" : "COUPE CAMBIOCORSA/GT/G-SPORT"},
			{"modelTypeID" : "MASERATI QUATTROPORTE","modelType" : "MASERATI QUATTROPORTE"}
        ],
        "MAZDA" : 
        [
			{"modelTypeID" : "MAZDA 3","modelType" : "MAZDA 3"},
			{"modelTypeID" : "MAZDA 5","modelType" : "MAZDA 5"},
			{"modelTypeID" : "MAZDA 6","modelType" : "MAZDA 6"},
			{"modelTypeID" : "MAZDA 6 SPORT WAGON","modelType" : "MAZDA 6 SPORT WAGON"},
			{"modelTypeID" : "MAZDA RX-8","modelType" : "MAZDA RX-8"},
			{"modelTypeID" : "MPV","modelType" : "MPV"},
			{"modelTypeID" : "MX-5","modelType" : "MX-5"}
        ],
        "MERCEDES BENZ" : 
        [
			{"modelTypeID" : "C230","modelType" : "C230"},
			{"modelTypeID" : "C280","modelType" : "C280"},
			{"modelTypeID" : "C280 4MATIC","modelType" : "C280 4MATIC"},
			{"modelTypeID" : "C350","modelType" : "C350"},
			{"modelTypeID" : "C350 4MATIC","modelType" : "C350 4MATIC"},
			{"modelTypeID" : "C55 AMG","modelType" : "C55 AMG"},
			{"modelTypeID" : "CL65 AMG","modelType" : "CL65 AMG"},
			{"modelTypeID" : "CLK350","modelType" : "CLK350"},
			{"modelTypeID" : "CLK350 (CABRIOLET)","modelType" : "CLK350 (CABRIOLET)"},
			{"modelTypeID" : "CLK55 AMG (CABRIOLET)","modelType" : "CLK55 AMG (CABRIOLET)"},
			{"modelTypeID" : "CLS500","modelType" : "CLS500"},
			{"modelTypeID" : "CLS55 AMG","modelType" : "CLS55 AMG"},
			{"modelTypeID" : "E320 CDI","modelType" : "E320 CDI"},
			{"modelTypeID" : "E350","modelType" : "E350"},
			{"modelTypeID" : "E350 (WAGON)","modelType" : "E350 (WAGON)"},
			{"modelTypeID" : "E350 4MATIC","modelType" : "E350 4MATIC"},
			{"modelTypeID" : "E350 4MATIC (WAGON)","modelType" : "E350 4MATIC (WAGON)"},
			{"modelTypeID" : "E500","modelType" : "E500"},
			{"modelTypeID" : "E55 AMG","modelType" : "E55 AMG"},
			{"modelTypeID" : "E55 AMG (WAGON)","modelType" : "E55 AMG (WAGON)"},
			{"modelTypeID" : "MAYBACH 57S","modelType" : "MAYBACH 57S"},
			{"modelTypeID" : "MAYBACH 62","modelType" : "MAYBACH 62"},
			{"modelTypeID" : "ML350","modelType" : "ML350"},
			{"modelTypeID" : "ML500","modelType" : "ML500"},
			{"modelTypeID" : "R350","modelType" : "R350"},
			{"modelTypeID" : "R500","modelType" : "R500"},
			{"modelTypeID" : "S350","modelType" : "S350"},
			{"modelTypeID" : "S430","modelType" : "S430"},
			{"modelTypeID" : "SL500","modelType" : "SL500"},
			{"modelTypeID" : "SL600","modelType" : "SL600"},
			{"modelTypeID" : "SL65 AMG","modelType" : "SL65 AMG"},
			{"modelTypeID" : "SLK280","modelType" : "SLK280"},
			{"modelTypeID" : "SLK350","modelType" : "SLK350"},
			{"modelTypeID" : "SLR","modelType" : "SLR"}
        ],
        "MITSUBISHI" : 
        [
			{"modelTypeID" : "ECLIPSE","modelType" : "ECLIPSE"},
			{"modelTypeID" : "ENDEAVOR 2WD","modelType" : "ENDEAVOR 2WD"},
			{"modelTypeID" : "ENDEAVOR 4WD","modelType" : "ENDEAVOR 4WD"},
			{"modelTypeID" : "GALANT","modelType" : "GALANT"},
			{"modelTypeID" : "LANCER","modelType" : "LANCER"},
			{"modelTypeID" : "LANCER EVOLUTION","modelType" : "LANCER EVOLUTION"},
			{"modelTypeID" : "LANCER SPORTBACK","modelType" : "LANCER SPORTBACK"},
			{"modelTypeID" : "MONTERO","modelType" : "MONTERO"},
			{"modelTypeID" : "OUTLANDER 2WD","modelType" : "OUTLANDER 2WD"},
			{"modelTypeID" : "OUTLANDER 4WD","modelType" : "OUTLANDER 4WD"}
        ],
        "NUMMI" : 
        [
			{"modelTypeID" : "VIBE","modelType" : "VIBE"}
        ],
        "NISSAN" : 
        [
			{"modelTypeID" : "350Z","modelType" : "350Z"},
			{"modelTypeID" : "350Z ROADSTER","modelType" : "350Z ROADSTER"},
			{"modelTypeID" : "ALTIMA","modelType" : "ALTIMA"},
			{"modelTypeID" : "ARMADA 2WD","modelType" : "ARMADA 2WD"},
			{"modelTypeID" : "ARMADA 4WD","modelType" : "ARMADA 4WD"},
			{"modelTypeID" : "FRONTIER 2WD","modelType" : "FRONTIER 2WD"},
			{"modelTypeID" : "FRONTIER V6-2WD","modelType" : "FRONTIER V6-2WD"},
			{"modelTypeID" : "FRONTIER V6-4WD","modelType" : "FRONTIER V6-4WD"},
			{"modelTypeID" : "FX35 AWD","modelType" : "FX35 AWD"},
			{"modelTypeID" : "FX35 RWD","modelType" : "FX35 RWD"},
			{"modelTypeID" : "FX45 AWD","modelType" : "FX45 AWD"},
			{"modelTypeID" : "G35","modelType" : "G35"},
			{"modelTypeID" : "M35","modelType" : "M35"},
			{"modelTypeID" : "M35X","modelType" : "M35X"},
			{"modelTypeID" : "M45","modelType" : "M45"},
			{"modelTypeID" : "MAXIMA","modelType" : "MAXIMA"},
			{"modelTypeID" : "MURANO AWD","modelType" : "MURANO AWD"},
			{"modelTypeID" : "MURANO FWD","modelType" : "MURANO FWD"},
			{"modelTypeID" : "PATHFINDER 2WD","modelType" : "PATHFINDER 2WD"},
			{"modelTypeID" : "PATHFINDER 4WD","modelType" : "PATHFINDER 4WD"},
			{"modelTypeID" : "Q45","modelType" : "Q45"},
			{"modelTypeID" : "Q45 SPORT","modelType" : "Q45 SPORT"},
			{"modelTypeID" : "QUEST","modelType" : "QUEST"},
			{"modelTypeID" : "QX56 4WD","modelType" : "QX56 4WD"},
			{"modelTypeID" : "SENTRA","modelType" : "SENTRA"},
			{"modelTypeID" : "TITAN 2WD","modelType" : "TITAN 2WD"},
			{"modelTypeID" : "TITAN 4WD","modelType" : "TITAN 4WD"},
			{"modelTypeID" : "XTERRA 2WD","modelType" : "XTERRA 2WD"},
			{"modelTypeID" : "XTERRA 4WD","modelType" : "XTERRA 4WD"}
        ],
        "PORSCHE" : 
        [
			{"modelTypeID" : "BOXSTER","modelType" : "BOXSTER"},
			{"modelTypeID" : "BOXSTER S","modelType" : "BOXSTER S"},
			{"modelTypeID" : "CARRERA 2 COUPE","modelType" : "CARRERA 2 COUPE"},
			{"modelTypeID" : "CAYENNE","modelType" : "CAYENNE"},
			{"modelTypeID" : "CAYENNE S","modelType" : "CAYENNE S"},
			{"modelTypeID" : "CAYENNE TURBO","modelType" : "CAYENNE TURBO"},
			{"modelTypeID" : "CAYMAN S","modelType" : "CAYMAN S"}
        ],
        "ROLLS-ROYCE" : 
        [
			{"modelTypeID" : "PHANTOM","modelType" : "PHANTOM"}
        ],
        "ROUSH" : 
        [
			{"modelTypeID" : "STAGE3 F150 SUPERCREW 4WD","modelType" : "STAGE3 F150 SUPERCREW 4WD"}
        ],
        "SPYKER" : 
        [
			{"modelTypeID" : "C8 SPYDER","modelType" : "C8 SPYDER"}
        ],
        "SUZUKI" : 
        [
			{"modelTypeID" : "AERIO","modelType" : "AERIO"},
			{"modelTypeID" : "AERIO SX","modelType" : "AERIO SX"},
			{"modelTypeID" : "AERIO SX AWD","modelType" : "AERIO SX AWD"},
			{"modelTypeID" : "GRAND VITARA XL-7","modelType" : "GRAND VITARA XL-7"},
			{"modelTypeID" : "GRAND VITARA XL-7 4WD","modelType" : "GRAND VITARA XL-7 4WD"},
			{"modelTypeID" : "GRAND VITARA XV6","modelType" : "GRAND VITARA XV6"},
			{"modelTypeID" : "GRAND VITARA XV6 AWD","modelType" : "GRAND VITARA XV6 AWD"}
        ],
        "TOYOTA" : 
        [
			{"modelTypeID" : "4RUNNER 2WD","modelType" : "4RUNNER 2WD"},
			{"modelTypeID" : "4RUNNER 4WD","modelType" : "4RUNNER 4WD"},
			{"modelTypeID" : "AVALON","modelType" : "AVALON"},
			{"modelTypeID" : "CAMRY","modelType" : "CAMRY"},
			{"modelTypeID" : "CAMRY SOLARA","modelType" : "CAMRY SOLARA"},
			{"modelTypeID" : "CAMRY SOLARA CONVERTIBLE","modelType" : "CAMRY SOLARA CONVERTIBLE"},
			{"modelTypeID" : "COROLLA","modelType" : "COROLLA"},
			{"modelTypeID" : "COROLLA MATRIX","modelType" : "COROLLA MATRIX"},
			{"modelTypeID" : "ES 330","modelType" : "ES 330"},
			{"modelTypeID" : "GS 300 4WD","modelType" : "GS 300 4WD"},
			{"modelTypeID" : "GS 300/GS 430","modelType" : "GS 300/GS 430"},
			{"modelTypeID" : "GX 470","modelType" : "GX 470"},
			{"modelTypeID" : "HIGHLANDER 2WD","modelType" : "HIGHLANDER 2WD"},
			{"modelTypeID" : "HIGHLANDER 4WD","modelType" : "HIGHLANDER 4WD"},
			{"modelTypeID" : "HIGHLANDER HYBRID 2WD","modelType" : "HIGHLANDER HYBRID 2WD"},
			{"modelTypeID" : "HIGHLANDER HYBRID 4WD","modelType" : "HIGHLANDER HYBRID 4WD"},
			{"modelTypeID" : "IS 250","modelType" : "IS 250"},
			{"modelTypeID" : "IS 250 AWD","modelType" : "IS 250 AWD"},
			{"modelTypeID" : "IS 350","modelType" : "IS 350"},
			{"modelTypeID" : "LS 430","modelType" : "LS 430"},
			{"modelTypeID" : "LX 470","modelType" : "LX 470"},
			{"modelTypeID" : "PRIUS","modelType" : "PRIUS"},
			{"modelTypeID" : "RAV4 2WD","modelType" : "RAV4 2WD"},
			{"modelTypeID" : "RAV4 4WD","modelType" : "RAV4 4WD"},
			{"modelTypeID" : "RX 330 2WD","modelType" : "RX 330 2WD"},
			{"modelTypeID" : "RX 330 4WD","modelType" : "RX 330 4WD"},
			{"modelTypeID" : "RX 400H 4WD","modelType" : "RX 400H 4WD"},
			{"modelTypeID" : "SC 430","modelType" : "SC 430"},
			{"modelTypeID" : "SCION TC","modelType" : "SCION TC"},
			{"modelTypeID" : "SCION XA","modelType" : "SCION XA"},
			{"modelTypeID" : "SCION XB","modelType" : "SCION XB"},
			{"modelTypeID" : "SEQUOIA 2WD","modelType" : "SEQUOIA 2WD"},
			{"modelTypeID" : "SEQUOIA 4WD","modelType" : "SEQUOIA 4WD"},
			{"modelTypeID" : "SIENNA 2WD","modelType" : "SIENNA 2WD"},
			{"modelTypeID" : "SIENNA 4WD","modelType" : "SIENNA 4WD"},
			{"modelTypeID" : "TOYOTA TACOMA 2WD","modelType" : "TOYOTA TACOMA 2WD"},
			{"modelTypeID" : "TOYOTA TACOMA 4WD","modelType" : "TOYOTA TACOMA 4WD"},
			{"modelTypeID" : "TOYOTA TUNDRA 2WD","modelType" : "TOYOTA TUNDRA 2WD"},
			{"modelTypeID" : "TOYOTA TUNDRA 4WD","modelType" : "TOYOTA TUNDRA 4WD"},
			{"modelTypeID" : "YARIS","modelType" : "YARIS"}
        ],
        "VOLKSWAGEN" : 
        [
			{"modelTypeID" : "GOLF","modelType" : "GOLF"},
			{"modelTypeID" : "JETTA","modelType" : "JETTA"},
			{"modelTypeID" : "NEW BEETLE","modelType" : "NEW BEETLE"},
			{"modelTypeID" : "NEW BEETLE CONVERTIBLE","modelType" : "NEW BEETLE CONVERTIBLE"},
			{"modelTypeID" : "PASSAT WAGON 4MOTION","modelType" : "PASSAT WAGON 4MOTION"},
			{"modelTypeID" : "PHAETON","modelType" : "PHAETON"},
			{"modelTypeID" : "RABBIT","modelType" : "RABBIT"},
			{"modelTypeID" : "TOUAREG","modelType" : "TOUAREG"},
			{"modelTypeID" : "TT COUPE QUATTRO","modelType" : "TT COUPE QUATTRO"},
			{"modelTypeID" : "TT ROADSTER QUATTRO","modelType" : "TT ROADSTER QUATTRO"}
        ],
        "VOLVO" : 
        [
			{"modelTypeID" : "NEW C70 CONVERTIBLE","modelType" : "NEW C70 CONVERTIBLE"},
			{"modelTypeID" : "S40 AWD","modelType" : "S40 AWD"},
			{"modelTypeID" : "S40 FWD","modelType" : "S40 FWD"},
			{"modelTypeID" : "S60 AWD","modelType" : "S60 AWD"},
			{"modelTypeID" : "S60 FWD","modelType" : "S60 FWD"},
			{"modelTypeID" : "S60 R AWD","modelType" : "S60 R AWD"},
			{"modelTypeID" : "S80 FWD","modelType" : "S80 FWD"},
			{"modelTypeID" : "V50 AWD","modelType" : "V50 AWD"},
			{"modelTypeID" : "V70 FWD","modelType" : "V70 FWD"},
			{"modelTypeID" : "V70 R AWD","modelType" : "V70 R AWD"},
			{"modelTypeID" : "XC 70 AWD","modelType" : "XC 70 AWD"},
			{"modelTypeID" : "XC 90 AWD","modelType" : "XC 90 AWD"},
			{"modelTypeID" : "XC 90 FWD","modelType" : "XC 90 FWD"}
        ]
                            };


      var ModelListItems= "";
      for (var i = 0; i < modelMakeJsonList.modelMakeTable.length; i++){
        ModelListItems+= "<option value='" + modelMakeJsonList.modelMakeTable[i].modelMakeID + "'>" + modelMakeJsonList.modelMakeTable[i].modelMake + "</option>";
      }
      $("#makeSelectionBox").html(ModelListItems);
    
    var updateSelectVehicleBox = function(make) {

        var listItems= "";
        for (var i = 0; i < modelTypeJsonList[make].length; i++){
            listItems+= "<option value='" + modelTypeJsonList[make][i].modelTypeID + "'>" + modelTypeJsonList[make][i].modelType + "</option>";
        }
        $("select#modelSelectionBox").html(listItems);
    }
   
    $("select#makeSelectionBox").on('change',function(){
        var selectedMake = $('#makeSelectionBox option:selected').text();
        updateSelectVehicleBox(selectedMake);
    });    		
}

 function vinValidator(vinToCheck) {
	var isVinValid = false;
	var vinRegex = /^(([a-h,A-H,j-n,J-N,p,P,r-t,R-T,v-z,V-Z,0-9]{9})([a-h,A-H,j-n,J-N,p,P,r-t,R-T,v-z,V-Z,0-9])([a-h,A-H,j-n,J-N,p,P,r-t,R-T,v-z,V-Z,0-9])(\d{6}))$/gi;
	
	var checkVin = vinToCheck.match(vinRegex);

	if (checkVin != null){
		isVinValid = true;
	}
 
	return isVinValid;
}

function createVehicle(){

var year = $('#yearSelect:selected');
var make = $('#makeSelectionBox:selected');
var model = $('#modelSelectionBox:selected');
var vin = $('#vinInput').val();
var mileageRaw = $('#mileageInput').val();
var mileageInt = parseInt(mileageRaw);
var checkIfInt = isNaN(mileageInt);
var modelValue = $('#modelSelectionBox').val();

	if (modelValue !== "-1" && vinValidator(vin) == true && checkIfInt == false){
		console.log("AJAX hit");
	$.ajax({
		type: "POST",
		url: "http://localhost:8080/repair_localsportsteam/vehicles",
		data: {year: year, make: make, model: model, vin: vin, mileage: mileageInt},
		success: successCreateVehicleFunction,
		error: failureCreateVehicleFunction
		});
	}
	
	else if (modelValue === "-1") {
	
	$("#vehicleMessage").text("You must select a vehicle Model");
	
	}
	
	else if (vinValidator(vin) == false) {
	
	$("#vehicleMessage").text("You must enter a valid Vehicle Identification Number");
	
	}
	
	else if (checkIfInt == true) {
	
	$("#vehicleMessage").text("You must enter a valid Mileage");
	
	}
}

function successCreateVehicleFunction() {
	$("#vehicleMessage").text("You've successfully added a Vehicle to your collection");
}
function failureCreateVehicleFunction() {

}
	