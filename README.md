事先说明：本插件代码提供者为Enron233，ThatMost（Macle）仅重制
# MacleCDK
 MineCraft服务器CDKey插件，使用这个插件，你可以创建绑定命令的CDK，当玩家输入CDK时，服务器便可以执行相应的命令，本插件可作为连通服务器内与现实世界的桥梁，广泛应用于：“服务器赞助系统、MineCraft无人售卡、服务器活动奖品发放”等多个方面。

## 插件特性

1. 全自动一键生成9位以上CDK
2. 可批量生成同类型CDK
3. 可设置命令的执行方式（控制台/玩家）
4. 插件轻量化
5. 配置文件高度自定义
6. 可自定义添加CDK
7. 支持批量导出CDK
8. （赶紧点击回复，马上你的建议将成为插件的特♂色~

## 插件命令

> 管理员命令:

| 命令 | 功能 |
| ---- | ---- |
| /maclecdk create [命令] [数量] | 创建`[数量]`个执行`[命令]`的CDK |
| /maclecdk export | 批量一键导出所有CDK |
| /maclecdk reload | 重载插件配置文件 |

> 玩家命令:

| 命令 | 功能 |
| ---- | ---- |
| /maclecdk [CDK] | 使用CDK |


## 插件权限

| 节点 | 描述 |
| ---- | ---- |
| `maclecdk.admin` | 总权限。给予此权限后无需剩余管理员权限 |

## 插件变量：
 
> `{player}`                         代表使用CDK的玩家


## 配置文件

```yaml 
1ll73hur1bhm:                           ## CDKey内容
   command: 'eco give {player} 100 '    ## 使用CDK后要执行的命令
   op: true                             ### 是否以OP（控制台）身份执行命令
   only: true                           ### 是否只能执行一次
```


## 插件下载

https://github.com/ThatMost0501/MacleCDK/release

## 开源地址

https://github.com/ThatMost0501/MacleCDK
