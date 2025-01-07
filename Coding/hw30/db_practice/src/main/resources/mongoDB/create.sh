use oms

db.createCollection("oms_company_address")

db.oms_company_address.insertMany([
    {
        addressName: "home",
        city: "San Diego",
        detailAddress: "1400 Shannon Ridge Ln",
        id: 1,
        name: "XXX ESX",
        phone: "666-6666-8888",
        province: "CA",
        receiveStatus: 0,
        region: "Cameral",
        sendStatus: 0
    },
    {
        "addressName": "office",
        "city": "San Diego",
        "detailAddress":"1400 Buafsl fdsa qew",
        "id":2,
        "name":
            "XXX ESX",
        "phone":"666-6666-8888",
        "province":"CA",
        "receiveStatus":0,
        "region":"Bual",
        "sendStatus":0
    },
    {
        "addressName":"home",
        "city":"Denver",
        "detailAddress":"1400 Illinois St",
        "id":3,
        "name":"dsfa zvc",
        "phone":"666-6666-8888",
        "province":"CO",
        "receiveStatus":0,
        "region":"Golden",
        "sendStatus":1
    },
    {
        "addressName":"office",
        "city":"Denver",
        "detailAddress":"2783 Aroura St",
        "id":4,
        "name":"dsfa zvc",
        "phone":"666-6666-8888",
        "province":"CO",
        "receiveStatus":1,
        "region":"DT",
        "sendStatus":1
    },
    {
        "addressName":"office","city":"Los Angeles","detailAddress":"1900 San Berdino Drive","id":5,"name":"Eric asdf","phone":"666-6666-8888","province":"CA","receiveStatus":0,"region":"DT","sendStatus":1
    },
    {
        "addressName":"home","city":"Los Angeles","detailAddress":"6787 Illinois Street","id":6,"name":"Eric asdf","phone":"666-6666-8888","province":"CA","receiveStatus":0,"region":"fsh","sendStatus":0
    },
    {
        "addressName":"Parent House","city":"Los Angeles","detailAddress":"6787 Figurora Street","id":7,"name":"Eric asdf","phone":"666-6666-8888","province":"CA","receiveStatus":0,"region":"fads","sendStatus":0
    },
    {
        "addressName":"Apartment","city":"San Fransisco","detailAddress":"9182 Finaqwec Drive","id":8,"name":"fasdf wyrueiwb","phone":"666-6666-8888","province":"CA","receiveStatus":0,"region":"wer","sendStatus":1
    },
    {
        "addressName":"office","city":"San Fransisco","detailAddress":"6312 ewuhce Street","id":9,"name":"fasdf wyrueiwb","phone":"666-6666-8888","province":"CA","receiveStatus":0,"region":"qwe","sendStatus":1
    },
    {
        "addressName":"Home","city":"San Fransisco","detailAddress":"3214 vsdave Ave","id":10,"name":"fasdf wyrueiwb","phone":"666-6666-8888","province":"CA","receiveStatus":1,"region":"qw","sendStatus":1
    }
])

db.oms_company_address.findOne()
db.oms_company_address.find({"id" : 1})
db.oms_company_address.find()
db.oms_company_address.deleteMany({ "city" : "Denver" })