import pandas as pd
import numpy as np
from numpy import array

from pprint import pprint
import random
import itertools



## Data
barcelona = [(1, 'ter Stegen'), (13, 'Cillessen'), (2, 'Semedo'), 
             (3, 'Pique'), (15, 'Lenglet'), (18, 'Alba'), (20, 'Roberto'), 
             (23, 'Umtiti'), (24, 'Vermaelen'), (4, 'Rakitic'), (5, 'Buskuets'), (6, 'Denis Suarez'),
             (7, 'Coutinho'), (8, 'Arthur'), (12, 'Rafinha'), (16, 'Samper'), (22, 'Vidal'), (26, 'Alena'), 
             (9, 'Luis Suarez'), (10, 'Messi'), (11, 'Dembele'), (14, 'Malcom'), (19, 'el Haddadi')]


barcelona_players = array(list(zip(*barcelona))[1])


## Direct addressing
def create_football_team_table(fill_with=''):
    max_size = 100
    return pd.DataFrame([fill_with for i in range(max_size)], index=pd.Index(range(max_size), name='idx'), columns=['player'])    


def fill_team_table(team, fill_with=''):
    table = create_football_team_table(fill_with)
    for number, name in team:
        table.loc[number] = name
    return table


def filling_percentage(table, fill_with=''):
    return 1 - len(table[table['player'] == fill_with]) / len(table)



## Chaining
class color:
    PURPLE = '\033[95m'
    CYAN = '\033[96m'
    DARKCYAN = '\033[36m'
    BLUE = '\033[94m'
    GREEN = '\033[92m'
    YELLOW = '\033[93m'
    RED = '\033[91m'
    BOLD = '\033[1m'
    UNDERLINE = '\033[4m'
    END = '\033[0m'


class HashTableChaining:
    def __init__(self, m=16):
        self.m = m
        self._table = [[] for i in range(self.m)]
        self._counter = 0

    def hash_fn(self, key):
        return int(key % self.m)

    def insert(self, key, value):
        hash_val = self.hash_fn(key)
        self._table[hash_val].append((key, value))
        self._counter += 1
        if self._counter >= self.m * 2:  # здесь x2 для целей демонстрации - на самом деле этот множитель не нужен
            self._rehash(self.m * 2)

    def delete(self, key):
        hash_val = self.hash_fn(key)
        bucket = self._table[hash_val]
        for idx, (key_list, value) in enumerate(bucket):
            if key_list == key:
                del bucket[idx]
                self._counter -= 1
                if self._counter < self.m:
                    self._rehash(self.m // 2)
                return value
        raise KeyError

    def search(self, key):
        hash_val = self.hash_fn(key)
        bucket = self._table[hash_val]   
        for idx, (key_list, value) in enumerate(bucket):
            if key_list == key:
                return value
        return None
    
    def pprint(self):
        pprint(list(enumerate(self._table)))
        
    def demonstrate(self, key, *args):
        hash_val = self.hash_fn(key)
        for idx, lst in enumerate(self._table):
            if idx == hash_val:
                print(color.RED + color.BOLD + f"{idx}: " + str(lst) + color.END)
            else:
                print(f"{idx}: " + str(lst))
                
    def _rehash(self, new_m):
        self.m = new_m  # т.к. хэш-функция зависит от m, она изменится
        # Дальше должна быть inplace-операция, но это демострационная таблица, я сэкономил время и сделал проще :)
        entries = sum(self._table, [])
        self._table = [[] for _ in range(self.m)]
        self._counter = 0
        for key, value in entries:
            self.insert(key, value)
                


def add_demo(action):
    act, key = action
    if act != "demonstrate":
        return [("demonstrate", key), action, ("demonstrate", key)]
    else:
        return [action]


def demonstrator_gen(team, m=10, actions=None):
    hash_table = HashTableChaining(m)
    for number, name in barcelona:
        hash_table.insert(number, name)
          
    if actions is None:
        actions = [("delete", (7,)), ("delete", (26,)), ("insert", (34, "Alena"))]
    actions = sum([add_demo(action) for action in actions], [])

    for action, key in actions:
        yield_value = getattr(hash_table, action)(*key)
        if yield_value is not None:
            yield color.RED + color.BOLD + f"{action} " + yield_value + color.END
        else:
            if action != 'demonstrate':
                yield color.RED + color.BOLD + f"{action} " + str(key) + color.END
            else:
                yield None