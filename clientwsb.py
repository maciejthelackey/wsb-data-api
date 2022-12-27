# bot.py
import os
import requests
import discord
import random
from dotenv import load_dotenv

load_dotenv()
TOKEN = os.getenv('DISCORD_TOKEN')

client = discord.Client(intents=discord.Intents.default())
api_url = "http://localhost:8080/wsbData/negativeComments?date=2"
response = requests.get(api_url)
response.json()


@client.event
async def on_ready():
    print(f'{client.user} has connected to Discord!')


client.run(TOKEN)


@client.event
async def on_message(message):
    if message.author == client.user:
        return

    test_lol = [api_url]

    if message.content == 'testing':
        response1 = random.choice(test_lol)
        response1.json()
        await message.channel.send(response1)

        client.run(TOKEN)
