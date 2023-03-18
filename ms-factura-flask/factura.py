import json

class Factura():
    def __init__(self, id, date, value, client_id, client_name):
        self.id = id
        self.date = date
        self.value = value
        self.client_id = client_id
        self.client_name = client_name
    
    def toJSON(self):
        return json.dumps(self, default=lambda o: o.__dict__, 
            sort_keys=True, indent=4)