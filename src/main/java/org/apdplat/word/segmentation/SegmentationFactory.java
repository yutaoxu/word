/**
 * 
 * APDPlat - Application Product Development Platform
 * Copyright (c) 2013, 杨尚川, yang-shangchuan@qq.com
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

package org.apdplat.word.segmentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

;

/**
 * 中文分词工厂类
 * 根据指定的分词算法返回分词实现
 * @author 杨尚川
 */
public class SegmentationFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(SegmentationFactory.class);
    private SegmentationFactory(){};
    public static Segmentation getSegmentation(SegmentationAlgorithm segmentationAlgorithm){
        String clazz = "org.apdplat.word.segmentation.impl."+segmentationAlgorithm.name();
        LOGGER.info("分词实现类："+clazz);
        try {
            return (Segmentation)Class.forName(clazz).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            LOGGER.info("构造分词实现类失败："+ex.getMessage());
        }
        return null;
    }
}
