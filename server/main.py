from flask import Flask, jsonify, request
from flask_cors import CORS

# 创建一个 Flask 应用
app = Flask(__name__)

# 全局允许跨域
CORS(app)

# 定义一个路由和视图函数
@app.route('/')
def home():
    return "Hello, Flask!"

# 定义一个带参数的路由
@app.route('/greet/<name>')
def greet(name):
    return f"Hello, {name}!"

# 定义一个返回 JSON 的路由
@app.route('/api/data', methods=['GET'])
def get_data():
    data = {
        'message': 'This is a JSON response',
        'status': 'success',
        'data': [1, 2, 3, 4, 5]
    }
    return jsonify(data)

# 定义一个处理 POST 请求的路由
@app.route('/api/submit', methods=['POST'])
def submit_data():
    request_data = request.get_json()
    if request_data and 'name' in request_data:
        return jsonify({'message': f"Received data: {request_data['name']}"})
    else:
        return jsonify({'error': 'Invalid data'}), 400

# 运行应用
if __name__ == '__main__':
    app.run(debug=True, port=8080)