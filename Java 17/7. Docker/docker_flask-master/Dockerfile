FROM python:3.9-slim-buster
WORKDIR /app
COPY requirements.txt requirements.txt
RUN pip install -r requirements.txt
EXPOSE 5000
ENV FLASK_APP=hello_flask.py
COPY . .
CMD ["flask", "run", "--host", "0.0.0.0"]
LABEL version="0.1"
