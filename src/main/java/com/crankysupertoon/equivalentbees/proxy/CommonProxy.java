/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.crankysupertoon.equivalentbees.proxy;

import com.crankysupertoon.equivalentbees.init.ObjectBatchLoader;
import com.crankysupertoon.equivalentbees.misc.Config;
import com.crankysupertoon.equivalentbees.network.PacketHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

public class CommonProxy {
	
	public static Configuration config;

	public void preInit(FMLPreInitializationEvent event) {
		File directory = event.getModConfigurationDirectory();
		config = new Configuration(new File(directory.getPath(), "EquivalentBees.cfg"));
		Config.readConfig();

		// Initialize our packet handler. Make sure the name is 20 characters or less!
		PacketHandler.registerMessages("EquivalentBees");
		// Initialization of blocks and items typically goes here:
		ObjectBatchLoader.preInit();

	}
	
	 public void init(FMLInitializationEvent event) {
		 ObjectBatchLoader.init();
	 }
	 
	 public void postInit(FMLPostInitializationEvent event) {
		 ObjectBatchLoader.postInit();
		 if(config.hasChanged()) {
		 	config.save();
		 }
	 }

	public void registerItem(Item item) {
		
	}


	public void registerBlock(Block block) {

	}
}
