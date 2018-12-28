package com.carlosrobertofreire.whiteboard;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.carlosrobertofreire.whiteboard.algorithm.AllAlgorithmTests;
import com.carlosrobertofreire.whiteboard.datastructure.AllDataStructureTests;

@RunWith(Suite.class)
@SuiteClasses({ AllAlgorithmTests.class, AllDataStructureTests.class })
public class AllTests {

}
