<template>
  <hr-chart :options="options"></hr-chart>
</template>

<script>
import HrChart from "@/business/components/common/chart/HrChart";
/* eslint-disable */
  export default {
    name: "CenterChart",
    components: {
      HrChart
    },
    props: {
      row: String
    },
    data() {
      return {
        options: {},
      }
    },
    watch: {
      row() {
        this.init();
      },
    },
    methods: {
      init() {
        let data = this.initData();
        this.options = {
          backgroundColor: '#fff',
          //第一个图表
          series: [
            {
            type: 'pie',
            hoverAnimation: true, //鼠标经过的特效
            left: 0,
            right: 0,
            bottom: 0,
            top: 0,
            radius: ['75%', '90%'],
            center: ['50%', '60%'],
            startAngle: 225,
            labelLine: {
              normal: {
                show: false
              }
            },
            label: {
              normal: {
                position: 'center'
              }
            },
            data: [
              {
              value: 100,
              itemStyle: {
                normal: {
                  color: '#E1E8EE'
                }
              },
            }, {
              value: 35,
              itemStyle: {
                normal: {
                  label: {
                    show: false
                  },
                  labelLine: {
                    show: false
                  },
                  color: "rgba(0,0,0,0)",
                  borderWidth: 0
                },
                emphasis: {
                  color: "rgba(0,0,0,0)",
                  borderWidth: 0
                }
              },
            },

            ]
          },
            //上层环形配置
            {
              type: 'pie',
              hoverAnimation: false, //鼠标经过的特效
              radius: ['75%', '90%'],
              center: ['50%', '60%'],
              startAngle: 225,
              labelLine: {
                normal: {
                  show: false
                }
              },
              label: {
                normal: {
                  position: 'center',
                  show: false
                }
              },
              detail: {
                valueAnimation: true,
                fontSize: 14,
                offsetCenter: [0, '70%']
              },
              data: [
                {
                  value: data,
                  itemStyle: {
                    normal: {
                      color: '#6F78CC'
                    }
                  },
                  label: {
                    normal: {
                      formatter: '{c}分',
                      position: 'center',
                      show: true,
                      textStyle: {
                        fontSize: '14',
                        fontWeight: 'normal',
                        color: '#34374E',
                      }
                    }
                  },
                  emphasis: {
                    show: false,
                    textStyle: {
                      fontSize: '14',
                      fontWeight: 'bold'
                    }
                  }
                },
                {
                  value: 32,
                  itemStyle: {
                    normal: {
                      label: {
                        show: false
                      },
                      labelLine: {
                        show: false
                      },
                      color: "rgba(0,0,0,0)",
                      borderWidth: 0
                    },
                    emphasis: {
                      color: "rgba(0,0,0,0)",
                      borderWidth: 0,
                    }
                  },
                },

              ]
            },
          ]
        };
      },
      initData () {
        if (!this.row) {
          return 100;
        } else {
          return parseInt(this.row);
        }
      },
    },
    mounted() {
      this.init();
    },
  }
</script>

<style scoped>
  .echarts {
    margin: 0;
    padding: 0;
    max-width: 150px;
    max-height: 100px;
  }
</style>
