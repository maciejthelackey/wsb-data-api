# bot.py
import os
import json
import discord
import requests
from discord.ext import commands
from discord.ext.commands import Bot
from dotenv import load_dotenv

intents = discord.Intents.all()
intents.members = True
load_dotenv()
TOKEN = os.getenv('DISCORD_TOKEN')
client = Bot(command_prefix='!', intents=intents)

api_url = "http://localhost:8080/wsbData/negativeComments"
date = 2
PARAMS = {'date': date}
r = requests.get(url=api_url, params=PARAMS)


# intents = discord.Intents.message_content


@client.event
async def on_ready():
    print(f'{client.user} has connected to Discord!')


@client.event
async def on_message(message):
    if message.author == client.user:
        return

    if message.content == 'testing':
        response1 = r

        print(r.text)

        await message.channel.send(response1.text)


@client.command()
async def embed(ctx):
    embed1 = discord.Embed(title="Sample Embed", url="https://twitter.com/tal_lord",
                           description="test with info", color=discord.Color.blue())
    await ctx.send(embed=embed1)


client.run(TOKEN)
