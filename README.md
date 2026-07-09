This server-side mod makes wardens ignore all sounds made by non-entities, such as pistons, dispensers, etc.

It can also ignore all non-**player** sounds, so the only thing that will attract them are players.

Configurable via the `/focusedwardens` command.


**Usage**:

- ```/focusedwardens enable/disable``` - Enables/Disables the functionality of this mod.

- ```/focusedwardens settings``` - Modifies the config of the mod (can also be done manually by changing the config file).

    -  ```/focusedwardens settings ignoreNonEntitySounds enable/disable``` - Makes the wardens ignore all sounds not caused by an entity (for example: redstone components).

    -  ```/focusedwardens settings ignoreNonPlayerSounds enable/disable``` - Makes the wardens ignore all sounds that did not come from players. (So this makes wardens ignore other mobs, and also non-entity sounds).


## Compatibility Table

| Fabric           | Forge            | NeoForge         |
|------------------|------------------| ---------------- |
| 1.19.4           | 1.19.4           | 1.20.4           |
| 1.20 - 1.20.4    | 1.20 - 1.20.1    | 1.20.5 - 1.21.11 |
| 1.20.5 - 1.21.11 | 1.20.5 - 1.21.11 | 26.1+            |
| 26.1+            | 26.1+            |                  |