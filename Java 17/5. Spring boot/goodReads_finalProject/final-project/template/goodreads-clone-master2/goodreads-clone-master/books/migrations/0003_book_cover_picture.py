# Generated by Django 4.0 on 2022-01-02 22:36

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('books', '0002_initial'),
    ]

    operations = [
        migrations.AddField(
            model_name='book',
            name='cover_picture',
            field=models.ImageField(default='default_cover.jpg', upload_to=''),
        ),
    ]
