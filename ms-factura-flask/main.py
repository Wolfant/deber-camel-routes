import json
import factura
from flask import Flask, jsonify, request, abort

app = Flask(__name__)

TEST_FACTURA = factura.Factura(12, "12/12/84", 12.2, "1712", "Antonio")
TEST_ARRAY_FACTURA = [json.loads(TEST_FACTURA.toJSON())]

@app.route('/factura/findAll', methods = ['GET'])
def returnAll():
    if(request.method == 'GET'):
        return jsonify(TEST_ARRAY_FACTURA)

@app.route('/factura/<int:id>', methods = ['GET'])
def findByCode(id):
    if(request.method == 'GET'):
        for factura in TEST_ARRAY_FACTURA:
            if(factura['id'] == id):
                return jsonify(factura)
        abort(404)

@app.route('/factura', methods = ['POST'])
def addNew():
    body = json.loads(request.data)
    if(request.headers.get('Content-Type')=='application/json'):
        new_factura = factura.Factura(body['id'],body['date'], body['value'],
                                      body['client_id'], body['client_name']) 
        TEST_ARRAY_FACTURA.append(json.loads(new_factura.toJSON()))
        return "OK"
    else:
        abort(400, "No valido")

if __name__=='__main__':
    app.run(debug=True)

