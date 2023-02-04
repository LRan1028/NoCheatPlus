/*
 * This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in thCut even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.catrainbow.nocheatplus.compat

import cn.nukkit.Player
import cn.nukkit.level.Location
import net.catrainbow.nocheatplus.NoCheatPlus
import net.catrainbow.nocheatplus.actions.ActionFactory
import net.catrainbow.nocheatplus.checks.CheckType

/**
 * 多核心适配
 *
 * @author Catrainbow
 */
class Bridge118 {

    companion object {

        //服务器是否拥有权威移动发包
        var server_auth_mode = false

        //重写核心拉回算法
        fun Player.setback(location: Location, type: CheckType) {
            if (ActionFactory.actionDataMap.containsKey(type.name)) if (ActionFactory.actionDataMap[type.name]!!.enableCancel) if (NoCheatPlus.instance.hasPlayer(
                    player.name
                )
            ) if (NoCheatPlus.instance.getPlayerProvider(player).getViolationData(type)
                    .getVL() >= ActionFactory.actionDataMap[type.name]!!.cancel
            ) player.teleport(location)
        }

    }

}