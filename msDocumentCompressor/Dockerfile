FROM python:3.7-alpine
WORKDIR /code
ENV FLASK_APP=app.py
ENV FLASK_RUN_HOST=0.0.0.0
RUN apk add -u zlib-dev jpeg-dev gcc musl-dev linux-headers
RUN python3 -m pip install --upgrade pip
COPY requirements.txt requirements.txt
RUN  apk add libffi-dev
RUN pip install -r requirements.txt
RUN pip install ghostscript
RUN apk update
RUN apk add --upgrade ghostscript-dev
EXPOSE 9003
COPY . .
CMD ["python", "ms_compress.py"]
